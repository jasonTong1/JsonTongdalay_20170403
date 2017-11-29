import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedReaderWriterDemo {

	static final String file_src = "d:\\rule\\我的青春谁做主.txt";
	static final String rule_txt = "d:\\rule\\rule.txt";
	static final String file_target = "d:\\rule\\我的青春谁做主10.txt";
	// filterElement 为过滤条件元素
	// ^(?!.*?filterElement).*$
	static final String regx = "(.*filterElement.*)|(^(?!.*?a).*$)";
	// isFilterType = true 过滤类型（去除rule文件中的内容） 否则就是 保留类型（保留文件中的内容）
	static final boolean isFilterType = false;

	public static void main(String[] args) throws IOException {

		copyFileByRuleFilter(createRuleList());
	}

	private static void copyFileByRuleFilter(ArrayList<String> rule_list)
			throws IOException {
		File file = new File(file_src);
		File file1 = new File(file_target); // 目标路径；

		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
		String str;
		while ((str = br.readLine()) != null) {
			// 如果满足过滤条件则复制到目标
			str = copyIfFilter(str, rule_list);
			bw.write(str);// 将数组内容写入；
			if (!"".equals(str)) {

				bw.newLine();
			}
			// 换行；
			bw.flush(); // 刷新；
		}
		System.out.println("rule_list is : " + rule_list);
		System.out.println("copy done.");
		br.close();
		bw.close();

	}

	private static ArrayList<String> createRuleList() throws IOException {
		ArrayList<String> rule_list = new ArrayList<String>();
		File file_rule = new File(rule_txt);

		BufferedReader br_rule = new BufferedReader(new FileReader(file_rule));
		String line_rule;

		while ((line_rule = br_rule.readLine()) != null) {
			if (!line_rule.trim().equals("")) {

				rule_list.add(line_rule.trim());
			}

		}

		br_rule.close();
		return rule_list;
	}

	private static String copyIfFilter(String str, ArrayList<String> rule_list) {
		String fliterStr = null;
		for (String filter : rule_list) {

			fliterStr = regx.replaceAll("filterElement", filter);

			if (str.matches(fliterStr)) {

				return isFilterType ? "" : str;
			}
		}
		return isFilterType ? str : "";

	}
}