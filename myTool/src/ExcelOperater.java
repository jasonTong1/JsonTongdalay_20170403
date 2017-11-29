//in ExcelOperater   

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileInputStream;

import java.io.InputStream;
import java.util.ArrayList;

import jxl.Cell;

import jxl.Sheet;

import jxl.Workbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelOperater

{

	static final String rule_txt = "E:\\excelDemo\\rule.txt";
	private static String path = "E:\\excelDemo\\excel";

	public static void main(String[] args)

	{
		searchTargetInFolder(path);

	}

	public static void searchTargetInFolder(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
			if (files[i].isDirectory()) {
				searchTargetInFolder(files[i].toString());
			} else {
				readExc(path + "\\" + files[i].getName());
			}

		}

	}

	public static void readExc(String excelName) {

		jxl.Workbook readwb = null;

		try

		{

			// ����Workbook����, ֻ��Workbook����

			// ֱ�Ӵӱ����ļ�����Workbook

			InputStream instream = new FileInputStream(excelName);

			readwb = Workbook.getWorkbook(instream);

			// Sheet���±��Ǵ�0��ʼ

			// ��ȡ��һ��Sheet��

			int sheetsNum = readwb.getNumberOfSheets();
			for (int i = 0; i < sheetsNum; i++) {

				Sheet readsheet = readwb.getSheet(i);
				readOneSheet(readsheet, i, excelName);
			}

			// ��ȡSheet������������������

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			readwb.close();

		}

	}

	public static void readOneSheet(Sheet readsheet, int sheetNum,
			String excelName) throws Exception {
		int rsColumns = readsheet.getColumns();
		String searchStr = "��";

		// ��ȡSheet������������������

		int rsRows = readsheet.getRows();

		// ��ȡָ����Ԫ��Ķ�������

		for (int i = 0; i < rsRows; i++)

		{
			for (int j = 0; j < rsColumns; j++) {
				Cell cell = readsheet.getCell(j, i);

				searchIfMatchTarget(cell.getContents(), i, j, sheetNum,
						excelName);
			}

		}

	}

	private static void searchIfMatchTarget(String contents, int i, int j,
			int sheetNum, String excelName) throws IOException {
		ArrayList<String> rule_list = createRuleList();
		for (String searchStr : rule_list) {
			if (contents.matches(searchStr)) {
				System.out.println(contents + " beFound: " + (i + 1) + " row "
						+ (j + 1) + " column " + (sheetNum + 1) + " sheet "
						+ excelName + " excel ");
			}
		}

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
}