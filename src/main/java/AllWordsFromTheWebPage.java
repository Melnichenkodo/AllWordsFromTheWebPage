import java.io.IOException;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class AllWordsFromTheWebPage {

    public static void main(String[] args) throws IOException {
        HtmlHandler handler = new HtmlHandler();
        StringBuilder htmlDocument = handler.handleWebPage("http://eda.ru/recepty/osnovnye-blyuda/kurica-pikasso-25902");
        System.out.println(HtmlParser.findHtmlTags(htmlDocument));
    }

}