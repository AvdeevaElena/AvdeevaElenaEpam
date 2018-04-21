package SE03;

import java.util.ArrayList;
import java.util.List;


public class Line {
    public int countLine;
    public String data;
    public List<Integer> countPic;
    public boolean isReferencePrevPic;
    public boolean isPicture;

    public Line(int countLine, String data, boolean isPicture) {
        this.countLine = countLine;
        this.data = data;
        this.countPic = new ArrayList<Integer>();
        this.isPicture = isPicture;
    }

    public void addNumbOfPicture(int countPic) {
        this.countPic.add(countPic);
    }

    public String getData() {
        return data;
    }

    public List<Integer> getNumbOfPics() {
        return countPic;
    }

    public int getcountLine() {
        return countLine;
    }

    public void setIsReferencePrevPic() {
        isReferencePrevPic = true;
    }

    public boolean isPicture() {
        return isPicture;
    }

    @Override
    public String toString() {
        return String.format("%4s : %3s : %4s : %-50s", countLine, isPicture ? "pic" : "ref", isPicture ? "pic" : (isReferencePrevPic ? "fail" : "ok"), countPic.toString());
    }

}