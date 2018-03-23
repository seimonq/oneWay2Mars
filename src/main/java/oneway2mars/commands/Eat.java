package oneway2mars.commands;

import de.lessvoid.nifty.controls.ConsoleCommands;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.screen.Screen;
import oneway2mars.model.AlphaAlphaModel;

public class Eat implements ConsoleCommands.ConsoleCommand{

    private final Screen screen;
    private final Element outputField;
    private AlphaAlphaModel model;

    public Eat(AlphaAlphaModel model, Screen screen) {
        this.model = model;
        this.screen = screen;
        this.outputField = screen.findElementById("outputBody");
    }

    public void execute(final String[] args) {

        outputField.getRenderer(TextRenderer.class).setText("EAT!");
//        String output = "";
//        System.out.println(args[0]); // this is always the command (in this case 'simple')
//
//        if (args.length > 1) {
//
//            Integer remainingFood = this.model.getNahrung() - Integer.valueOf(args[1]);
//
//            if(remainingFood > 0) {
//                this.model.setNahrung(remainingFood);
//                output = args[1] + " Rationen gegessen. Es verbleiben noch " + remainingFood + " Rationen.";
//            }
//            else {
//                output = " Es wurden bereits alle Rationen verbraucht.";
//            }
//        }
//        outputField.getRenderer(TextRenderer.class).setText(output);
    }
}


