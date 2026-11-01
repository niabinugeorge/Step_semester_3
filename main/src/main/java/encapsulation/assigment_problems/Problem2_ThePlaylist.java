package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Problem 2: The Playlist
 *
 * A Playlist that stores songs in a private array and only ever hands
 * out a COPY of its contents, so outside code can't alter the real list.
 */
public class Problem2_ThePlaylist {

    static class Playlist {
        private final String[] songs;
        private int songCount;

        public Playlist(int maxSize) {
            this.songs = new String[maxSize];
            this.songCount = 0;
        }

        public void addSong(String title) {
            if (songCount >= songs.length) {
                System.out.println("Playlist is full — cannot add \"" + title + "\".");
                return;
            }
            songs[songCount] = title;
            songCount++;
        }

        /** Returns a copy of the songs added so far — never the internal array. */
        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs: " + Arrays.toString(copy));

        copy[0] = "Hacked"; // Modifying the copy...
        System.out.println("Modified copy: " + Arrays.toString(copy));
        System.out.println("Playlist's real contents: " + Arrays.toString(p.getSongs())); // ...still "Song A"
        System.out.println("Song count: " + p.getSongCount());
    }
}
