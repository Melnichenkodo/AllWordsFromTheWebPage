package State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12032016 on 05.03.2017.
 */
public class HtmlAnalyzer {

    private List<String> result = new ArrayList<String>();

    private State notWordState;
    private State wordState;
    private State openTagState;
    private State insideTagState;
    private State scriptState;
    //    private State innerTagState;
    private State attributeState;
    private State styleState;

    public State state;

    private StringBuilder word = new StringBuilder();

    public HtmlAnalyzer() {
        notWordState = new NotWordState(this);
        wordState = new WordState(this);
        openTagState = new OpenTagState(this);
        insideTagState = new InsideTagState(this);
        attributeState = new AttributeState(this);
        scriptState = new ScriptState(this);
        styleState = new StyleState(this);
        state = notWordState;
    }

    public void analyze(char letter) {
        state.analyze(letter);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    State getNotWordState() {
        return notWordState;
    }

    State getInsideTagState() {
        return insideTagState;
    }

    State getAttributeState() {
        return attributeState;
    }

    State getWordState() {
        return wordState;
    }

    State getOpenTagState() {
        return openTagState;
    }

    State getScriptState() {
        return scriptState;
    }

    State getStyleState() {
        return styleState;
    }

    void addCurrentWordToResult() {
        result.add(word.toString());
        word.delete(0, word.length());
    }

    public List getResult() {
        return result;
    }

    void addLetterToWord(char letter) {
        word.append(letter);
    }

}
