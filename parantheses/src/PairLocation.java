public class PairLocation {
    private int openIndex, closeIndex;

    public PairLocation(int openIndex, int closeIndex) {
        this.openIndex = openIndex;
        this.closeIndex = closeIndex;
    }

    public int getOpenIndex() {
        return openIndex;
    }

    public void setOpenIndex(int openIndex) {
        this.openIndex = openIndex;
    }

    public int getCloseIndex() {
        return closeIndex;
    }

    public void setCloseIndex(int closeIndex) {
        this.closeIndex = closeIndex;
    }
}
