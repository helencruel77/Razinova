package laba;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Changes extends JPanel{

	private static int[] memory;
	private static int countElement;
	private static int countFree;

	public Changes(int[] memory, int countElement, int countFree, ArrayList<File> files) {
		this.memory = memory;
		this.countElement = countElement;
		this.countFree = countFree;
	}

	public static boolean addFile(String name, int size) {
		Manager manager = new Manager();
		if (manager.getFiles() != null) {
			for (int i = 0; i < manager.getFiles().size(); i++) {
				if (manager.getFiles().get(i).getNode().getName().equals(name)) {
					JOptionPane.showMessageDialog(null, "Такой файл уже есть.");
					return false;
				}
			}
		}
		if (size / 4 > countFree) {
			JOptionPane.showMessageDialog(null, "Слишком большой файл.");
			return false;
		}
		countFree -= size / 4;
		countElement = size / 4;
		Place[] ps = new Place[countElement];
		int ps_id = 0;
		for (int i = 0; i < memory.length && countElement > 0; i++) {
			if (memory[i] == 1) {
				countElement--;
				memory[i] = 2;
				ps[ps_id++] = new Place(i);
			}
		}

		int sizeLocal = 0;
		if(size / 4 > 3) {
			sizeLocal = 3*4;
			size -=sizeLocal;
		} else {
			sizeLocal = size;
			size = 0;
		}
		IndexNode knot = new IndexNode(ps,name, sizeLocal);
		knot.indexNode(ps);
		while (size > 0) {
			if(size / 4 > 3) {
				sizeLocal = 3*4;
				size -=sizeLocal;
				knot.setNode(ps,name, sizeLocal);
			} else {
				sizeLocal = size;
				size = 0;
				knot.setNode(ps,name, sizeLocal);
			}
		}
		File file = new File(knot);
		manager.getFiles().add(file);
		return true;
	}

	public static void Delete(String s) {
		Manager manager = new Manager();
		Place[] ps = getfile(s).getNode().getpositions();
		if (ps != null) {
			for (int i = 0; i < ps.length; i++) {
				memory[ps[i].getI()] = 1;
			}
		}
		countFree += getfile(s).getNode().fileSize() / 2;
		manager.getFiles().remove(getfile(s));
	}

	public static File getfile(String s) {
		Manager manager = new Manager();
		if (manager.getFiles() != null) {
			for (int i = 0; i < manager.getFiles().size(); i++) {
				if (manager.getFiles().get(i).getNode().getName().equals(s)) {
					return manager.getFiles().get(i);
				}
			}
		}
		return null;
	}
}
