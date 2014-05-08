package model;

//import model.javacandidatestruct.CandidateClass;

import java.io.*;

/**
 * @author Nicolas Burroni
 * @since 5/8/2014
 */
public class Test {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("ccd");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectInputStream os = null;
		try {
			os = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//CandidateClass ccd = (CandidateClass) os.readObject();
			Object ccd = os.readObject();
			System.out.println(ccd);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
