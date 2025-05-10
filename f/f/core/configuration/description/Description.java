import java.util.ArrayList;

public class Description {
    private List<BlockElemects>block;
    public builder(){
        return new DescriptionBuilder();
    }
    public Description(List<BlockElement>block){
        this.block = block;
    }
    public static class DescriptionBuilder{
        private final List<BlockElement>block = new ArrayList<>();
        
        public List<BlockElement> text(String text){
            block.add(TextElement.text(text));
        }

        public Description build(){
            return new Description(block);
        }

    }
}
