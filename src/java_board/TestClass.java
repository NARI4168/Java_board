package java_board;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {

		// 테스트 게시물 100개
		ArrayList<Article> testList = new ArrayList<>();
		for (int i = 1; i <= 30; i++) {
			Article article = new Article(i, "제목" + i, "내용2" + i, "2020-07-29 09:49:00", 30, null);
			testList.add(article);
		}

		int currentPageNo = 1;
		int totalCountOfArticle = testList.size();
		int articlesPerpage = 3;
		int startPage = 1;
		int lastPage = (int)Math.ceil((double)totalCountOfArticle / (double)articlesPerpage);
		int pageCount = 10;

		Scanner sc = new Scanner(System.in);

		while (true) {
			int startIndex = (currentPageNo - 1) * articlesPerpage;
			int endIndex = startIndex + articlesPerpage;

			for (int i = startIndex; i < endIndex; i++) {
				System.out.println(">>번호 :" + testList.get(i).id);
				System.out.println("제목 :" + testList.get(i).title);
				System.out.println("내용 :" + testList.get(i).body);
			}

			// 페이징
			startPage = currentPageNo - 2;
			if (startPage <= 0) {
				startPage = 1;
			}
			System.out.println(" ");
			System.out.println(" ");

			// 1~3페이지까지 출력안되게...
			if(currentPageNo >= 4) {				
				System.out.print(1 + "... ");
			}
			
			for (int i = startPage; i < startPage + 5; i++) {
				
				if (i == currentPageNo) {
					System.out.print("[" + i + "] ");
				} else {
					System.out.print(i + " ");
				}
			}
			
			
			// 마지막에서 마지막-2페이지까지 출력안되게...
			if(currentPageNo< (lastPage-2)) {
			System.out.println("..." + lastPage + "\n");
			}
			
			System.out.println("1.next   2.prev");
			int cmd = Integer.parseInt(sc.nextLine());
			if (cmd == 1) {
				currentPageNo++;
			} else if (cmd == 2) {
				currentPageNo--;
			}
		}

	}

}
