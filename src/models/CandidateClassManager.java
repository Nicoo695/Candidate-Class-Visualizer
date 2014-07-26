package models;

import models.javacandidatestruct.CandidateClass;
import models.javacandidatestruct.JavaAttribute;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nicolas Burroni
 * @since 7/23/2014
 */
public class CandidateClassManager {

	private Set<CandidateClass> candidateClassSet;
	private List<CandidateClass> candidateClassList;

	//Debugging constructor
	public CandidateClassManager(List<CandidateClass> ccds){
		this.candidateClassList = ccds;
	}

	public CandidateClassManager(){
		this.candidateClassSet = new LinkedHashSet<>();
	}

	public CandidateClassManager(File legacyCodeFile){
		//this.candidateClassList = TODO call method to parse legacy code and generate the CandidateClasses

	}

	/**
	 * Imports a CandidateClass to the database.
	 * @param ccdFile File to read.
	 * @return true if it was imported correctly, false if the CandidateClass already exists in the database.
	 * @throws IOException if there was an error while trying to read the file.
	 * @throws ClassNotFoundException if the file was not a CandidateClass.
	 */
	public boolean importCandidateClass(File ccdFile) throws IOException, ClassNotFoundException {
		return candidateClassSet.add(readCandidateClass(ccdFile));
	}

	/**
	 * Reads a file and returns the CandidateClass object serialized.
	 * @param ccdFile File to read.
	 * @return the read CandidateClass.
	 * @throws IOException if there was an error while trying to read the file.
	 * @throws ClassNotFoundException if the file was not a CandidateClass.
	 */
	public CandidateClass readCandidateClass(File ccdFile) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ccdFile));
		return (CandidateClass) objectInputStream.readObject();
	}

	public String[][] getCandidateClassesToString(){
		String[][] ccds = new String[candidateClassList.size()][3];
		for (int i = 0; i < ccds.length; i++) {
			CandidateClass ccd = candidateClassList.get(i);
			ccds[i][0] = ccd.getName();
			concatList(ccds, i, 1, ccd.getAttributes());
			concatList(ccds, i, 2, ccd.getMethods());
		}

		return ccds;
	}

	private void concatList(String[][] destination, int i, int j, List toConcat){
		String concatenated = "";
		for (Object obj : toConcat) {
			concatenated = concatenated.concat(obj.toString() + "\n");  //TODO change JavaMethod's toString?
		}
		destination[i][j] = concatenated;
	}

}
