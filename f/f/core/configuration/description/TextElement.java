import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

public class TextElement implements BlockElement,InlineElement {
    private final String format;
    private final List<InlineElement> element;
    private final EnumSet<TextStyle> textstyles = EnumSet.noneOf(TextStyle.class);

    private TextElement(String format,List<InlineElement>element){
        this.format = format;
        this.element = element;
    }
    public static TextElement text(String format, InlineElement ... element){
        return new TextElement(format,Arrays.asList(element));
    }
    public static TextElement text(String format){
        return new TextElement(format,Collections.emptyList());
    }
} 
