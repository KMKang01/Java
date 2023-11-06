package codeErorrDetector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class sendCmd {

	private String commend;

	public sendCmd() {
		ProcessBuilder b = new ProcessBuilder("cmd");
		b.redirectErrorStream(true);
	}

	public void getCmd(String name) { // 저장된 .java파일을 컴파일 한다.

		try {
			ProcessBuilder b = new ProcessBuilder("cmd");
			b.redirectErrorStream(true);
			Process p = b.start();

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			writer.write("cd C:\\testCode\n");
			writer.flush();
			writer.write("javac -g "+name+".java -encoding UTF-8\n");
			writer.flush();
			writer.write("exit" + "\n"); writer.flush();

			BufferedReader std = new BufferedReader(new InputStreamReader(p.getInputStream())); // 이부분이 메시지를 읽어온다
			String outputLine = "";
			String outputMessage = "";
			while ((outputLine = std.readLine()) != null) {
				outputMessage += outputLine + "\r\n";
			}
			System.out.println(outputMessage);//오류 출력
			p.waitFor();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
class DotJava { // 스트링을 .java파일로 저장한다.
	Scanner sc = new Scanner(System.in);

	public String saveAsDotJava(String data) throws IOException {
		System.out.print("저장할 이름을 입력:");
		String name = sc.next();
		FileWriter fw = new FileWriter("C:\\testCode\\"+name+".java"); // 이름은 클레스명과 같아야한다. 조치가 필요함
		fw.write(data);
		fw.close();
		return name;
	}
}
