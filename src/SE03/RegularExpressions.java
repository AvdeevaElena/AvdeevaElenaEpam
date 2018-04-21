package SE03;
//Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки
//        последовательно или нет, а также выделить все предложения, в которых встречаются
//        ссылки на рисунки. Для разбора текста использовать регулярные выражения.

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    private static final String FILEPARSE = "Java.SE.03.Information handling_task_attachment.html";
    private Pattern picturePattern = Pattern.compile("pic([0-9]{1,2})[.]jpg");
    private Pattern referencePattern = Pattern.compile("[Р|р](ис[.]|исунке)[ ]?([0-9]{1,2})");

    public void parse(List<Line> bothLines) {
        try {
            InputStream fin = getClass().getResourceAsStream(FILEPARSE);
            BufferedReader in = new BufferedReader(new InputStreamReader(fin, "cp1251"));
            int numberOfLine = 0;
            String str;
            while ((str = in.readLine()) != null) {
                Matcher m = picturePattern.matcher(str);
                Matcher p = referencePattern.matcher(str);
                numberOfLine++;
                if (m.find()) {
                    bothLines.add(new Line(numberOfLine, str, true));
                } else if (p.find()) {
                    bothLines.add(new Line(numberOfLine, str, false));
                }
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setState(List<Line> bothLines) {
        for (Line line : getLines(bothLines, false)) {
            Matcher m = referencePattern.matcher(line.getData());
            while (m.find()) {
                line.addNumbOfPicture(Integer.valueOf(m.group(2)));
            }
        }
        for (Line line : getLines(bothLines, true)) {
            Matcher m = picturePattern.matcher(line.getData());
            if (m.find()) {
                line.addNumbOfPicture(Integer.valueOf(m.group(1)));
            }
        }
        for (Line line : getLines(bothLines, false)) {
            for (int i = 0; i < line.getNumbOfPics().size(); i++) {
                if (line.getcountLine() < getNumbOfPicLine(line.getNumbOfPics().get(i), bothLines))
                    line.setIsReferencePrevPic();
            }
        }
    }

    public List<Line> getLines(List<Line> bothLines, boolean isPic) {
        List<Line> result = new ArrayList<Line>();
        for (Line line : bothLines)
            if (line.isPicture == isPic) result.add(line);
        return result;
    }

    private int getNumbOfPicLine(int numbOfPic, List<Line> bothLines) {
        for (Line line : getLines(bothLines, true)) {
            if (line.getNumbOfPics().get(0) == numbOfPic) return line.getcountLine();
        }
        return 0;
    }

    public static void main(String[] args) {

        List<Line> bothLines = new ArrayList<Line>();
        RegularExpressions regExp = new RegularExpressions();
        regExp.parse(bothLines);
        regExp.setState(bothLines);
        printLines(bothLines);
    }

    public static void printLines(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(line);
        }
    }
}
