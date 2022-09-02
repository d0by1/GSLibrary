package eu.gs.gslibrary.conditions;

import dev.dejvokep.boostedyaml.block.implementation.Section;
import eu.gs.gslibrary.GSLibrary;
import eu.gs.gslibrary.utils.replacement.Replacement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConditionValue {

    private String type, input, output;
    private ConditionsAPI conditionsAPI;
    private Condition condition;
    private Replacement replacement;

    public ConditionValue(Section section) {
        conditionsAPI = GSLibrary.getInstance().getConditionsAPI();

        type = section.getString("type", "null");
        input = section.getString("input", "null");
        output = section.getString("output", "null");

        if(!conditionsAPI.getConditions().containsKey(type)) {
            System.out.println("Condition "+type+" doesn't exist!");
            return;
        }

        condition = conditionsAPI.getConditions().get(type);
    }

    public ConditionValue(String type, String input, String output) {
        conditionsAPI = GSLibrary.getInstance().getConditionsAPI();

        this.type = type;
        this.input = input;
        this.output = output;

        if(!conditionsAPI.getConditions().containsKey(type)) {
            System.out.println("Condition "+type+" doesn't exist!");
            return;
        }

        condition = conditionsAPI.getConditions().get(type);
    }

    public ConditionValue setReplacement(Replacement replacement) {
        this.replacement = replacement;
        return this;
    }

    public String getInput() {
        if(replacement != null) {
            return replacement.replace(null, input);
        }
        return input;
    }
}
