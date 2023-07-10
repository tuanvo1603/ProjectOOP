package crawl.historicalfigures;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.File;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;

import crawl.Crawl;
import models.HistoricalFigure;

public class CrawlFigures extends Crawl {
	public static void crawlFigures() throws IOException {
		String url = "https://nguoikesu.com/nhan-vat";
		Document doc = null;
		Document doc1 = null;

		ObjectMapper objectMapper = new ObjectMapper();
		// Choose a page
		for (int i1 = 0; i1 <= 290; i1++) {
			try {
				doc = Jsoup.connect(url + "?start=" + (5 * i1)).get();
			} catch (HttpStatusException e) {
				System.out.println("Could not find the web page: " + url);
				continue;
			} catch (IOException e) {
				e.printStackTrace();
			}
			Elements pageheader = doc.select(".page-header");
			// Choose a figure
			for (int i2 = 0; i2 < pageheader.size(); i2++) {
				HistoricalFigure figure = null;
				// Connect href
				String regexLink = pageheader.get(i2).select("a[href]").attr("abs:href");
				String regex = "\\b(https?|ftp|file):\\/\\/[\\-A-Za-z0-9+&@#\\/\\%?=~_|!:,.;]*[\\-A-Za-z0-9+&@#\\/%=~_|]";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(regexLink);
				while (matcher.find()) {
					String link = matcher.group();
					link = URLDecoder.decode(link, "UTF-8");

					System.out.println("\nDang crawl nhan vat o link: " + link);

					try {
						doc1 = Jsoup.connect(link).timeout(120000).get();

						String charName = "Chưa rõ"; // Tên nhân vật - tên hay được gọi, tiêu đề trang
						String realName = "Chưa rõ"; // Tên thật - nếu sau khi check không thấy gì (Chưa rõ) thì gán =
														// charName
						ArrayList<String> alterName = new ArrayList<String>(); // Lưu các tên khác của nhân vật
						String charMother = "Chưa rõ"; // Mẹ
						String charFather = "Chưa rõ"; // Bố
						String dateOfBirth = "Chưa rõ"; // Ngày sinh
						String lostDate = "Chưa rõ"; // Ngày mất
						String preceeded = "Chưa rõ"; // Tiền nhiệm
						String succeeded = "Chưa rõ"; // kế nhiệm
						String era = "Chưa rõ"; // Triều đại ?
						String workTime = "Chưa rõ"; // Thời gian tại chức
						String position = "Chưa rõ"; // Chức vụ

						/*
						 * Có các trường hợp sau: 1. Không có bảng thông tin, không rõ thông tin 2.
						 * Không có bảng thông tin, có thông tin (ý là các đoạn p) 3. Có bảng thông tin,
						 * có thông tin
						 * 
						 * Ưu tiên như sau: -> Nếu có bảng thông tin -> ưu tiên 1 -> Nếu không có bảng
						 * thông tin -> tìm ở các đoạn p Đối với tên nhân vật thì ưu tiên page header ->
						 * đoạn p -> bảng thông tin
						 */

						// Lấy ra bảng thông tin (nếu có)
						Element infoTable = doc1.selectFirst("table[class^=infobox]");

						// Lấy tên nhân vật từ tiêu đề - page header
						Element firstFoundCharName = doc1.selectFirst("div[class=page-header] > h2");
						if (firstFoundCharName != null)
							charName = firstFoundCharName.text();

						if (infoTable != null) {
							Elements infoTableRows = infoTable.select("tr");
							int numberOfTr = infoTableRows.size();
							for (int i = 0; i < numberOfTr; ++i) {
								// Thẻ đầu tiên là tên (hầu như) => cho vào tên phụ vì nó không hay chính xác
								if (i == 0) {
									Element tableHead = infoTableRows.get(i).selectFirst("th");

									if (tableHead != null) {
										tableHead.select("sup").remove();
										alterName.add(tableHead.text());
									}
								} else {
									Element tableHead = infoTableRows.get(i).selectFirst("th");

									// Trong khi crawl co 1 so nhan vat co nhieu chuc vu, tien nhiem
									// ke nhiem,... => lay nhung cai dau crawl duoc, bo nhung cai sau
									if (tableHead != null) {
										tableHead.select("sup").remove();
										String tableHeadContent = tableHead.text();

										// Chuc vu se dung truoc thoi gian tai vi hoac nhiem ky =>
										// Check neu sau no la nhiem ky / tgian tai chuc thi do la chuc vu
										// 1 khi co vi tri r thi thoi khong chay if nay nua
										if (i < numberOfTr - 1
												&& (position.equals("Chưa rõ") || positionCheck(position))) {
											Element nextTableHead = infoTableRows.get(i + 1).selectFirst("th");

											if (nextTableHead != null) {
												nextTableHead.select("sup").remove();
												if (workTimeCheck(nextTableHead.text())) {
													if (!tableHeadContent.equals("Thuộc")) {
														position = tableHeadContent;
													}
													continue;
												}
											}
										}

										if (positionCheck(tableHeadContent)
												&& (position.equals("Chưa rõ") || position.equals("Thuộc"))) {
											// Neu trong xau co hoang de,... => chuc vu
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												position = tableData.text();
											} else
												position = tableHeadContent;
										} else if (workTimeCheck(tableHeadContent) && workTime.equals("Chưa rõ")) { // Thoi
																													// gian
																													// tai
																													// chuc
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												workTime = tableData.text();
											}
										} else if (tableHeadContent.equals("Tiền nhiệm")
												&& preceeded.equals("Chưa rõ")) { // Preceeded
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												preceeded = tableData.text();
											}
										} else if (tableHeadContent.equals("Kế nhiệm") && succeeded.equals("Chưa rõ")) { // Succeeded
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												succeeded = tableData.text();
											}
										} else if (eraCheck(tableHeadContent) && era.equals("Chưa rõ")) {
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												era = tableData.text();
											}
										} else if (fatherCheck(tableHeadContent) && charFather.equals("Chưa rõ")) { // Father
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												charFather = tableData.text();
											}
										} else if (motherCheck(tableHeadContent) && charMother.equals("Chưa rõ")) { // Mother
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												charMother = tableData.text();
											}
										} else if (birthCheck(tableHeadContent) && dateOfBirth.equals("Chưa rõ")) { // Birth
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												dateOfBirth = tableData.text();
											}
										} else if (tableHeadContent.equals("Mất") && lostDate.equals("Chưa rõ")) { // Lost
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												lostDate = tableData.text();
											}
										} else if (realNameCheck(tableHeadContent) && realName.equals("Chưa rõ")) {
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												realName = tableData.text();
											}
										} else if (alterNameCheck(tableHeadContent)) {
											Element tableData = infoTableRows.get(i).selectFirst("td");
											if (tableData != null) {
												tableData.select("sup").remove();
												if (!tableData.text().toLowerCase().contains("không")) {
													alterName.add(tableData.text());
												}
											}
										}
									} else {
										Elements numberOfTd = infoTableRows.get(i).select("td");

										// Loại bỏ những trường hợp chứa thẻ img,...
										if (numberOfTd.size() < 2) {
											continue;
										}

										// Co the co truong hop no la the td thay vi th
										Element tableDataAlter = infoTableRows.get(i).selectFirst("td");

										if (tableDataAlter != null) {
											tableDataAlter.select("sup").remove();
											String tableDataAlterContent = tableDataAlter.text();

											if (i < numberOfTr - 1
													&& (position.equals("Chưa rõ") || positionCheck(position))) {
												Element nextTableData = infoTableRows.get(i + 1).selectFirst("td");

												if (nextTableData != null) {
													nextTableData.select("sup").remove();
													if (workTimeCheck(nextTableData.text())) {
														if (!tableDataAlterContent.equals("Thuộc")) {
															position = tableDataAlterContent;
														}
														continue;
													}
												}
											}

											if (positionCheck(tableDataAlterContent)
													&& (position.equals("Chưa rõ") || position.equals("Thuộc"))) { // Neu
																													// trong
																													// xau
																													// co
																													// hoang
																													// de,...
																													// =>
																													// chuc
																													// vu
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													position = tableData.text();
												} else
													position = tableDataAlterContent;
											} else if (workTimeCheck(tableDataAlterContent)
													&& workTime.equals("Chưa rõ")) { // thoi gian tai chuc
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													workTime = tableData.text();
												}
											} else if (tableDataAlterContent.equals("Tiền nhiệm")
													&& preceeded.equals("Chưa rõ")) { // Preceeded
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													preceeded = tableData.text();
												}
											} else if (tableDataAlterContent.equals("Kế nhiệm")
													&& succeeded.equals("Chưa rõ")) { // Succeeded
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													succeeded = tableData.text();
												}
											} else if (eraCheck(tableDataAlterContent) && era.equals("Chưa rõ")) {
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													era = tableData.text();
												}
											} else if (fatherCheck(tableDataAlterContent)
													&& charFather.equals("Chưa rõ")) { // Father
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													charFather = tableData.text();
												}
											} else if (motherCheck(tableDataAlterContent)
													&& charMother.equals("Chưa rõ")) { // Mother
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													charMother = tableData.text();
												}
											} else if (birthCheck(tableDataAlterContent)
													&& dateOfBirth.equals("Chưa rõ")) { // Birth
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													dateOfBirth = tableData.text();
												}
											} else if (tableDataAlterContent.equals("Mất")
													&& lostDate.equals("Chưa rõ")) { // Lost
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													lostDate = tableData.text();
												}
											} else if (realNameCheck(tableDataAlterContent)
													&& realName.equals("Chưa rõ")) {
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													realName = tableData.text();
												}
											} else if (alterNameCheck(tableDataAlterContent)) {
												Element tableData = infoTableRows.get(i).select("td").get(1);
												if (tableData != null) {
													tableData.select("sup").remove();
													if (!tableData.text().toLowerCase().contains("không")) {
														alterName.add(tableData.text());
													}
												}
											}
										}
									}
								}
							}
						}

						Element contentBody = doc1.selectFirst("p");

						// Chỉ lấy ở thẻ p đầu tiên vì hầu như thông tin tập hợp ở đó
						// Có thể thiếu trường hợp
						Elements contentBodyElements = contentBody.children();

						for (Element item : contentBodyElements) {
							if (item.tagName().equals("p")) {
								Element firstParagraph = item;
								// Loc ra cac the chu thich
								// [class~=(annotation).*]
								firstParagraph.select("sup").remove();
								// Lấy các thẻ a là thẻ con của p
								Elements pATags = firstParagraph.select("a");
								// Noi dung doan van ban sau khi loc
								String firstPContent = firstParagraph.text();

								Element firstBTag = firstParagraph.selectFirst("b");

								// Tu dau van ban cho den truoc dau ( se la ten nhan vat
								Pattern p = Pattern.compile("^[^(]*[(]", Pattern.CASE_INSENSITIVE);
								Matcher m = p.matcher(firstPContent);

								if (m.find()) {
									String result = m.group();
									// Loai bo dau ngoac don
									result = result.substring(0, result.length() - 1).trim();
									if (firstBTag != null) {
										String name = firstBTag.text();
										int startIndex = result.indexOf(name);
										result = result.substring(0, startIndex + name.length());
									}
									if (charName.equals("Chưa rõ"))
										charName = result;
									else
										alterName.add(result);
								} else {
									// Neu khong tim thay thi su dung the b dau tien - the b dau tien la ten cua
									// nhan vat
									if (firstBTag != null) {
										// Neu ten lay dc tu tieu de roi thi thoi cho vao alter
										// cho do thieu truong hop ten
										if (charName.equals("Chưa rõ"))
											charName = firstBTag.text();
										else
											alterName.add(firstBTag.text());
									}
								}

								// Tim ngay sinh / hoac thoi gian lam viec
								Pattern birthRegex = Pattern.compile("\\(([^)]*)\\)", Pattern.UNICODE_CASE);
								Matcher birthMatch = birthRegex.matcher(firstPContent);

								while (birthMatch.find()) {
									String firstResult = birthMatch.group(0);

									// Lay ra doan xau co format (...) => lay ... - đoạn text trong ngoặc
									// Truong hop doan trong ngoac khong phai ngay sinh
									Pattern checkValid = Pattern.compile("sinh|tháng|năm|-|–");
									Matcher matchValid = checkValid.matcher(firstResult);

									if (matchValid.find()) {
										// Loai bo phan chu Han: ...,/; ... => lay phan ... sau
										int startIndex = firstResult.lastIndexOf(',');
										if (startIndex == -1) {
											startIndex = firstResult.lastIndexOf(';');
											if (startIndex == -1) {
												startIndex = firstResult.lastIndexOf('；');
												if (startIndex == -1) {
													startIndex = 1;
												} else
													startIndex++;
											} else
												startIndex++;
										} else
											startIndex++;

										String contentInParen = firstResult.substring(startIndex,
												firstResult.length() - 1);
										if (contentInParen.contains("trị vì")) {
											if (workTime.equals("Chưa rõ")) {
												workTime = contentInParen;
											}
										} else {
											// Chia ra nam sinh voi nam mat
											String[] splitString = {};
											if (contentInParen.contains("-")) {
												splitString = contentInParen.split("-");
											} else {
												splitString = contentInParen.split("–");
											}

											if (splitString.length == 1) {
												if (dateOfBirth.equals("Chưa rõ"))
													dateOfBirth = splitString[0].trim();
											} else {
												if (dateOfBirth.equals("Chưa rõ"))
													dateOfBirth = splitString[0].trim();
												if (lostDate.equals("Chưa rõ"))
													lostDate = splitString[1].trim();
											}
										}
										break;
									} else {
										int start = firstPContent.indexOf(')');
										firstPContent = firstPContent.substring(start + 1);
										birthMatch = birthRegex.matcher(firstPContent);
									}
								}

								// Lay chuc vu - nghe nghiep cua nhan vat
								firstPContent = firstParagraph.text();
								boolean outLoop = true;
								while (outLoop) {
									// kiem tra sau chu "la" la gi?
									int start = firstPContent.indexOf("là"); // tra ve vi tri chu l cua "la" dau tien
																				// tim thay
									if (start != -1 && start < firstPContent.length() - 3) {
										// Neu la chu in hoa || hoac la con, lang? ... => bo TH chu la nay di :v
										if (Character.isUpperCase(firstPContent.charAt(start + 3))
												|| firstPContent.charAt(start + 2) != ' ') {
											// Con truong hop la mot
											// Truong hop chu lam
											if (firstPContent.charAt(start + 2) == 'm'
													&& firstPContent.charAt(start + 3) == ' ') {
												outLoop = false;
											} else
												firstPContent = firstPContent.substring(start + 3);
										} else
											outLoop = false;
									} else
										outLoop = false;
								}

								String backupInfo = "";
								Pattern posiRegex = Pattern.compile("(là|làm)[^.]*[.]");
								Matcher posiMatcher = posiRegex.matcher(firstPContent);

								while (posiMatcher.find()) {
									String result = posiMatcher.group(0);
									if (!result.contains(":")) {
										// Ham check not position de kiem tra truong hop
										// la nguoi lang nao, la con cua ai,... => khong phai vi tri
										if (checkNotPosition(result)) {
											// Chi lay ket qua dau tien tim duoc
											if (backupInfo.equals(""))
												backupInfo = result;
										} else {
											if (position.equals("Chưa rõ") || positionCheck(position)
													|| position.equals("Thuộc")) {
												position = result.substring(0, result.length() - 1);
												break;
											}
//			                                else {
//			                                    // Neu da co chuc vu hop li r thi doan thong tin tim dc coi nhu thong tin
//			                                    // bo sung
//			                                    position = position + " (" + result.substring(0, result.length() - 1) + ")";
//			                                }
										}
									}
								}

								// Trong truong hop khong co ket qua nao khac ngoai: la con cua, la nguoi lang
								// abc,...
								// Thi ta lay tam
								if (position.equals("Chưa rõ") || positionCheck(position) || position.equals("Thuộc")) {
									if (!backupInfo.equals(""))
										position = backupInfo;
								}

								// Reset lai para cho loc cai khac
								firstPContent = firstParagraph.text();

								// Lay trieu dai, nha???
								for (Element a : pATags) {
									String hrefValue = a.attr("href");
									if (hrefValue.contains("nha-")) {
										if (era.equals("Chưa rõ")) {
											era = a.text();
											break;
										}
									}
								}

								// Lay ra ten that
								// Cac truong hop: ten that la, ten khai sinh la, ten huy => ,.;
								if (realName.equals("Chưa rõ")) {
									posiRegex = Pattern.compile(
											"(nguyên danh|tên thật|tên khai sinh|tên húy)[^,.;)]*[,.;)]",
											Pattern.CASE_INSENSITIVE);
									posiMatcher = posiRegex.matcher(firstPContent);

									if (posiMatcher.find()) {
										String result = posiMatcher.group(0);
										if (result.charAt(result.length() - 1) == ')' && result.indexOf("(") != -1) {
											realName = result;
										} else
											realName = result.substring(0, result.length() - 1);
									} else
										realName = charName;
								}

								// Lay ra cac ten khac
								// Cac truong hop: con goi la, tu, tên tự, nien hieu, duoi ten goi, thông gọi,
								// biet hieu => ,.;
								if (alterName.size() == 0) {
									posiRegex = Pattern.compile(
											"(còn gọi|tên tự|niên hiệu|dưới tên gọi|thông gọi|biệt hiệu)[^,.;)]*[,.;)]",
											Pattern.CASE_INSENSITIVE);
									posiMatcher = posiRegex.matcher(firstPContent);

									if (posiMatcher.find()) {
										String result = posiMatcher.group(0);
										if (result.charAt(result.length() - 1) == ')' && result.indexOf("(") != -1) {
											alterName.add(result);
										} else
											alterName.add(result.substring(0, result.length() - 1));
									}
								}
								break;
							}
						}

						System.out.println("Name: " + charName);
						System.out.println("Real name: " + realName);
						System.out.print("Alter name: [");
						if (alterName.size() > 0) {
							for (int i = 0; i < alterName.size(); ++i) {
								if (i < alterName.size() - 1) {
									System.out.print(alterName.get(i) + ", ");
								} else
									System.out.print(alterName.get(i) + "]\n");
							}
						} else
							System.out.print("]\n");
						System.out.println("Date of birth and birth place: " + dateOfBirth);
						System.out.println("Lost date and lost place: " + lostDate);
						System.out.println("Position: " + position);
						System.out.println("Work time: " + workTime);
						System.out.println("Era: " + era);
						System.out.println("Father: " + charFather);
						System.out.println("Mother: " + charMother);
						System.out.println("Preceeded: " + preceeded);
						System.out.println("Succeeded: " + succeeded);

						// Them nhan vat crawl duoc vao database
						if (!charName.equals("Chưa rõ")) {
							figure = new HistoricalFigure(charName, realName, alterName, dateOfBirth, lostDate, position,
									workTime, era, charFather, charMother, preceeded, succeeded);
						}

					} catch (HttpStatusException e) {
						if (e.getStatusCode() == 404) {
							System.out.println("Error 404: Page not found for URL: " + url);
							continue; // Skip to the next iteration
						} else {
							// Handle other HTTP errors
							System.err.println("HTTP Error: " + e.getStatusCode());
							e.printStackTrace();
						}
					} catch (Exception e) {
						// Handle other exceptions
						e.printStackTrace();
					}
				}
				String jsonData = objectMapper.writeValueAsString(figure);

				String fileName = "data" + (i1 * 5 + i2 + 1) + ".json";
				String directory = "src/main/resources/Json/HistoricalFigures/";
				FileWriter fileWriter = new FileWriter(new File(directory, fileName));
				fileWriter.write(jsonData);
				fileWriter.close();
			}
		}
	}
}
