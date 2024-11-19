public class Song {
    private String title;
    private String artist;
    private int minutes;
    private int second;
    private int numPlays = 0;
    private int IDX_TITLE = 0;
    private int IDX_ARTIST = 1;
    private int IDX_LENGTH = 2;
    private int IDX_NUM_PLAYS = 3;

    public Song(String info) {
        String[] infoArr = info.split(",");
        title = infoArr[IDX_TITLE];
        artist = infoArr[IDX_ARTIST];
        String[] infoArr2 = infoArr[IDX_LENGTH].split(":");
        minutes = Integer.parseInt(infoArr2[0]);
        second = Integer.parseInt(infoArr2[1]);
        if (infoArr.length == 4) {
            numPlays = Integer.parseInt(infoArr[3]);
        }
    }

    public Song(Song other) {
        this.title = other.title;
        this.artist = other.artist;
        this.minutes = other.minutes;
        this.second = other.second;
        this.numPlays = other.numPlays;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSecond() {
        return second;
    }

    public int getIDX_LENGTH() {
        return minutes * 60 + second;
    }

    public int getNumPlays() {
        return numPlays;
    }

    public void incrementNumPlays() {
        numPlays++;
    }

    public String toString() {
        if (numPlays == 0) {
            return "Song{" +
                    "title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", minutes=" + minutes +
                    ", second=" + second +
                    ", IDX_TITLE=" + IDX_TITLE +
                    ", IDX_ARTIST=" + IDX_ARTIST +
                    ", IDX_LENGTH=" + IDX_LENGTH +
                    ", IDX_NUM_PLAYS=" + IDX_NUM_PLAYS +
                    '}';

        }
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", minutes=" + minutes +
                ", second=" + second +
                ", numPlays=" + numPlays +
                ", IDX_TITLE=" + IDX_TITLE +
                ", IDX_ARTIST=" + IDX_ARTIST +
                ", IDX_LENGTH=" + IDX_LENGTH +
                ", IDX_NUM_PLAYS=" + IDX_NUM_PLAYS +
                '}';
    }
}
