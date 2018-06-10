package rpn.Tokenizers;

import rpn.Registries.OperatorRegistered;
import rpn.Registries.Registry;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    public Tokenizer(){}

    public List<String> tokenize(Registry registry, String s, String delim) throws Exception {
        /* Création du pattern de vérification */
        StringBuilder patternString = new StringBuilder();
        patternString.append("[");
        for(OperatorRegistered entry : registry.getEntries()){
            patternString.append(entry.getPattern());
            patternString.append("|");
        }
        patternString.append(delim);
        patternString.append("]*");

        //On vérifie que la string n'est constitué que de chiffes et d'opérande
        Pattern pattern = Pattern.compile(patternString.toString());
        Matcher m = pattern.matcher(s);

        if(m.matches()){
            s = s.trim();
            return Arrays.asList(s.split(delim));
        }
        throw new Exception("Invalid character in expression");
    }
}
