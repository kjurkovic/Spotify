import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ZipfsSong {

	private static int m;

	public static void main(String[] args) {
		LinkedList<Song> list = processEntries();
		for (int i = 0; i < m; i++)
			System.out.println(list.get(i).getSongName());
	}

	private static LinkedList<Song> processEntries() {
		Scanner scanner = new Scanner(System.in);
		StringTokenizer inputDefinition = new StringTokenizer(
				scanner.nextLine());
		int n = Integer.parseInt(inputDefinition.nextToken());
		m = Integer.parseInt(inputDefinition.nextToken());

		LinkedList<Song> inputList = new LinkedList<Song>();
		for (int i = 1; i <= n; i++) {
			StringTokenizer songDefinition = new StringTokenizer(
					scanner.nextLine());
			Song song = new Song();
			song.setSongNumber(i);
			song.setTimesPlayed(Integer.parseInt(songDefinition.nextToken()));
			song.setSongName(songDefinition.nextToken());
			song.setSongQuality(song.getSongNumber() * song.getTimesPlayed());

			inputList.add(song);
		}

		Collections.sort(inputList);
		return inputList;
	}

	private static class Song implements Comparable<Song> {
		private int timesPlayed;
		private String songName;
		private double songQuality;
		private int songNumber;

		public int getTimesPlayed() {
			return timesPlayed;
		}

		public void setTimesPlayed(int timesPlayed) {
			this.timesPlayed = timesPlayed;
		}

		public String getSongName() {
			return songName;
		}

		public void setSongName(String songName) {
			this.songName = songName;
		}

		public double getSongQuality() {
			return songQuality;
		}

		public void setSongQuality(double songQuality) {
			this.songQuality = songQuality;
		}

		public int getSongNumber() {
			return songNumber;
		}

		public void setSongNumber(int songNumber) {
			this.songNumber = songNumber;
		}

		@Override
		public int compareTo(Song o) {

			if (o.songQuality > songQuality)
				return 1;
			else if (o.songQuality == songQuality)
				return (songNumber > o.songNumber) ? 1 : -1;
			else
				return -1;
		}

	}

}
