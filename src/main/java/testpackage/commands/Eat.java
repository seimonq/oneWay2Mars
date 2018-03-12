package testpackage.commands;

import de.lessvoid.nifty.controls.ConsoleCommands;
import testpackage.model.AlphaAlphaModel;

public class Eat implements ConsoleCommands.ConsoleCommand{

    private AlphaAlphaModel model;

    public Eat(AlphaAlphaModel model) {
        this.model = model;
    }

    public void execute(final String[] args) {
        System.out.println(args[0]); // this is always the command (in this case 'simple')
        if (args.length > 1) {
            System.out.println(args[1] + " Rationen gegessen.");
            Integer remainingFood = model.getNahrung() - Integer.valueOf(args[1]);
            if(remainingFood > 0) {
                model.setNahrung(remainingFood);
                System.out.println(args[1] + " Rationen gegessen. Es verbleiben noch " + remainingFood + " Rationen.");
            }
            else {
                System.out.println(" Es wurden bereits alle Rationen verbraucht.");
            }
        }
    }
}


