package crawl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl {

	public static String extractWordsAfterKeyword(String input, String keyword) {
		StringBuilder result = new StringBuilder();

		Pattern pattern = Pattern.compile("(?<=" + Pattern.quote(keyword) + ")[^\\.]*",
				Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			String match = matcher.group().trim();
			String replacement = match.replace(keyword, "").trim();
			result.append(replacement);
			result.append(" ");
		}

		return result.toString().trim();
	}

	public static String extractLocation(String input) {
		String result = null;
		result = extractWordsAfterKeyword(input, "ở");
		if (result.equals(""))
			result = extractWordsAfterKeyword(input, "vùng đất");
		else
			return result;
		if (result.equals(""))
			result = extractWordsAfterKeyword(input, "tọa lạc");
		else
			return result;
		if (result.equals(""))
			result = extractWordsAfterKeyword(input, "nằm trên");
		else
			return result;
		if (result.equals(""))
			result = extractWordsAfterKeyword(input, "vị trí");
		else
			return result;
		if (result.equals(""))
			result = extractWordsAfterKeyword(input, "xã");
		else
			return result;
		if (result.equals(""))
			return result;
		else
			return "xã " + result;
	}

	public static List<String> filterStringsStartingWithKeyword(ArrayList<String> strings, String keyword) {
		List<String> filteredStrings = new ArrayList<String>();

		for (String str : strings) {
			if (str.startsWith(keyword)) {
				filteredStrings.add(str);
			}
		}

		return filteredStrings;
	}

	public static int countSpaces(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		return count;
	}

	public static boolean positionCheck(String position) {
		return position.equalsIgnoreCase("Công việc") || position.equalsIgnoreCase("Nghề nghiệp")
				|| position.equalsIgnoreCase("Cấp bậc") || position.equalsIgnoreCase("Đơn vị")
				|| position.equalsIgnoreCase("Chức quan cao nhất") || position.equalsIgnoreCase("Chức vụ")
				|| position.equalsIgnoreCase("Vị trí");
	}

	public static boolean checkNotPosition(String text) {
		return text.contains("làng") || text.contains("con của");
	}

	public static boolean workTimeCheck(String workTime) {
		return workTime.equalsIgnoreCase("Trị vì") || workTime.equalsIgnoreCase("trị vì")
				|| workTime.equalsIgnoreCase("Tại vị") || workTime.equalsIgnoreCase("Nhiệm kỳ")
				|| workTime.equalsIgnoreCase("Năm tại ngũ") || workTime.equalsIgnoreCase("Hoạt động");
	}

	public static boolean fatherCheck(String father) {
		return father.equalsIgnoreCase("Thân phụ") || father.equalsIgnoreCase("Cha")
				|| father.equalsIgnoreCase("Bố mẹ");
	}

	public static boolean motherCheck(String mother) {
		return mother.equalsIgnoreCase("Thân mẫu") || mother.equalsIgnoreCase("Mẹ") || mother.equalsIgnoreCase("Bố mẹ");
	}

	public static boolean eraCheck(String era) {
		return era.equalsIgnoreCase("Hoàng tộc") || era.equalsIgnoreCase("Triều đại") || era.equalsIgnoreCase("Gia tộc")
				|| era.equalsIgnoreCase("Kỷ nguyên");
	}

	public static boolean birthCheck(String birth) {
		return birth.equalsIgnoreCase("Ngày sinh") || birth.equalsIgnoreCase("Sinh");
	}

	public static boolean realNameCheck(String realName) {
		return realName.equalsIgnoreCase("Húy") || realName.equalsIgnoreCase("Tên thật")
				|| realName.equalsIgnoreCase("tên thật") || realName.equalsIgnoreCase("Tên đầy đủ")
				|| realName.equalsIgnoreCase("Tên húy");
	}

	public static boolean alterNameCheck(String alterName) {
		return alterName.equalsIgnoreCase("Thụy hiệu") || alterName.equalsIgnoreCase("Niên hiệu")
				|| alterName.equalsIgnoreCase("Tên khác") || alterName.equalsIgnoreCase("Tước hiệu")
				|| alterName.equalsIgnoreCase("Tước vị") || alterName.equalsIgnoreCase("Hiệu")
				|| alterName.equalsIgnoreCase("Bút danh") || alterName.equalsIgnoreCase("Miếu hiệu");
	}

	public static boolean locationCheck(String location) {
		return location.equalsIgnoreCase("Khu vực") || location.equalsIgnoreCase("Địa chỉ")
				|| location.equalsIgnoreCase("Địa điểm") || location.equalsIgnoreCase("Vị trí");
	}

	public static String timeCheck(String time) {
//		return time.equalsIgnoreCase("Khởi công") || time.equalsIgnoreCase("Hoàn thành")
//				|| time.equalsIgnoreCase("Thành lập") || time.equalsIgnoreCase("Khởi lập")
		if(time.contains("khởi công")) return "khởi công";
		if(time.contains("thành lập")) return "thành lập";
		if(time.contains("khởi lập")) return "khởi lập";
		if(time.contains("hoàn thành")) return "hoàn thành";
		if(time.contains("khánh thành")) return "khánh thành";
		return "";
	}

	public static boolean notCharName(String test) {
		// Xem co phai xau rong k?
		if (test.equals(""))
			return true;

		// Xem neu chi co 1 ky tu
		if (test.length() == 1)
			return true;

		// Kiem tra xem co chu so khong?
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(test);

		if (m.find()) {
			return true;
		}

		// Kiem tra neu ten qua ngan
		String[] splitted = test.split(" ");
		if (splitted.length < 2)
			return true;
		else {
			// Kiem tra co phai tat ca deu in hoa khong?
			for (String s : splitted) {
				if (!Character.isUpperCase(s.charAt(0))) {
					return true;
				}
			}
		}

		// Mang chua nhung tu khong hop le doi voi ten 1 nhan vat
		String[] notValid = { "nhà", "triều", "miếu", "sông", "phủ", "đền", "biển", "thành", "di sản", "cố đô",
				"di tích", "tổ chức", "thế kỷ", "trận", "chùa", "đường", "phố", "bản", "người", "động", "bộ", "sửa",
				"xã", "kháng chiến", "chiến khu", "quốc lộ", "cách mạng", "chú thích", "nguồn", "đảo", "chiến dịch",
				"trung đoàn", "đại đoàn", "chiều", "xã", "huyện", "tỉnh", "thủy điện", "hang", "UBND", "ủy", "thời",
				"khảo cổ", "lịch sử", "đá", "thị trấn", "cực", "vĩ độ", "kinh độ", "tọa độ", "việt nam", "trống",
				"biên giới", "tiếng", "cờ", "ruộng", "biên giới", "này", "kiểm chứng", "'", "[", "]", "/", "km", "cm",
				"suối", "gỗ", "trám", "-" };
		String lowerCaseTest = test.toLowerCase();
		for (String s : notValid) {
			if (lowerCaseTest.contains(s))
				return true;
		}
		return false;
	}

	public static boolean peopleCheck(String thing) {
		String[] vietnameseLastNames = { "An Dương", "Âu Cơ", "Bà Triệu", "Bảo Đại", "Bộ ", "Bùi ", "Cao ", "Dương ", "Duy ",
				"Đặng ", "Đinh ", "Đỗ ", "Gia Long ", "Đồng Khánh", "Hai Bà Trưng", "Hàm Nghi", "Hồ ", "Hoàng ", "Huỳnh ",
				"Kinh ", "Kỷ ", "Lạc Long Quân", "Lê ", "Lý ", "Mạc ", "Mai Hắc Đế", "Minh Mạng", "Mỵ Châu", "Ngô ", "Nguyễn ",
				"Vương ", "Vũ ", "Võ ", "Trương ", "Trịnh ", "Triệu ", "Trần ", "Tôn ", "Phan ", "Phạm " };
		String[] notVietNameseLastNames = {" Bộ", " Bùi", " Cao", " Dương", " Duy", " Đặng", " Đinh", " Đỗ", " Hồ", " Hoàng",
				" Huỳnh", " Kinh", " Kỷ", " Lê", " Lý", " Mạc", " Ngô", " Nguyễn", " Vương", " Vũ", " Võ", " Trường", " Trịnh"
				," Triệu", " Trần", " Tôn", " Phan", " Phạm"};
		for (String s : vietnameseLastNames) {
			if (thing.contains(s)) {
				for(String d : notVietNameseLastNames)
					if(thing.contains(d))
						return false;
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkOccurrence(String name, ArrayList<String> relatedThings) {
		for(String relatedThing: relatedThings) {
			if(name.equals(relatedThing))
				return false;
		}
		return true;
	}

}