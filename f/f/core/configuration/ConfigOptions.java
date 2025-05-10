package f.core.configuration;

public class ConfigOptions {

    
    public OptionBuilder key(String key){
        return new OptionBuilder(key);
    }
    public static final class OptionBuilder{
        private final String key;
        OptionBuilder(String key){
            this.key = key;
        }

        public TypedConfigOptionBuilder<String>stringType(){
            return new TypedConfigOptionBuilder<>(key,String.class);
        }
    }
    public static class TypedConfigOptionBuilder<T>{
        private final String key;
        private final Class<T> clazz;

        TypedConfigOptionBuilder(String key,Class<T> clazz){
            this.key = key;
            this.clazz = clazz;
        }
        public ConfifOption<T>noDefaultValue(){
            return new ConfigOption<>(key,clazz,Description.builder().text("").build(),null,false);

        }


    }
}
