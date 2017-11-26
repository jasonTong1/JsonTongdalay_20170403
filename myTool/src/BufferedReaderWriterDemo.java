import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedReaderWriterDemo {

	static final String file_src = "d:\\rule\\�ҵ��ഺ˭����.txt";
	static final String rule_txt = "d:\\rule\\rule.txt";
	static final String file_target = "d:\\rule\\�ҵ��ഺ˭����10.txt";
	//filterElement Ϊ��������Ԫ��
	//^(?!.*?filterElement).*$
	static final String regx = "(.*filterElement.*)|(^(?!.*?a).*$)";
	//isFilterType = true �������ͣ�ȥ��rule�ļ��е����ݣ� ������� �������ͣ������ļ��е����ݣ�
	static final boolean isFilterType = false;

	public static void main(String[] args) throws IOException {
		File file = new File(file_src);
		File file1 = new File(file_target); // Ŀ��·����
		File file_rule = new File(rule_txt);

		BufferedReader br_rule = new BufferedReader(new FileReader(file_rule));
		String line_rule;
		ArrayList<String> rule_list = new ArrayList<String>();

		while ((line_rule = br_rule.readLine()) != null) {
			if (!line_rule.trim().equals("")) {

				rule_list.add(line_rule.trim());
			}

		}

		br_rule.close();
//		System.out.println(rule_list);
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
		String str;
		while ((str = br.readLine()) != null) {
			// �����������������Ƶ�Ŀ��
			// if (copyIfFilter(str,rule_list)) {
			str = copyIfFilter(str, rule_list);
			bw.write(str);// ����������д�룻
			if (!"".equals(str)) {

				bw.newLine();
			}
			// ���У�
			bw.flush(); // ˢ�£�
			// }
		}
		System.out.println("rule_list is : " + rule_list);
		System.out.println("copy done.");
		br.close();
		bw.close();
	}

	private static String copyIfFilter(String str, ArrayList<String> rule_list) {
		String fliterStr = null;
		for (String filter : rule_list) {

			fliterStr = regx.replaceAll("filterElement", filter);

			if (str.matches(fliterStr)) {

				return isFilterType ? "" :str;
			}
		}
		return isFilterType ? str :"";

	}
}