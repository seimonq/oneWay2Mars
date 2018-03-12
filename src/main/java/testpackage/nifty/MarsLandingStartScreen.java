
package testpackage.nifty;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.InputManager;
import com.jme3.math.ColorRGBA;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.ViewPort;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyMethodInvoker;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import testpackage.AlphaAlphaMarsApplication;

public class MarsLandingStartScreen extends BaseAppState implements ScreenController {

    private Nifty nifty;
    private Screen screen;
    private AlphaAlphaMarsApplication app;
    private AssetManager assetManager;
    private InputManager inputManager;
    private AudioRenderer audioRenderer;
    private ViewPort guiViewPort;
    private NiftyJmeDisplay niftyDisplay;

    @Override
    public void initialize(Application app) {
        this.app = (AlphaAlphaMarsApplication) app;
        this.assetManager = app.getAssetManager();
        this.inputManager = app.getInputManager();
        this.audioRenderer= app.getAudioRenderer();
        this.guiViewPort  = app.getGuiViewPort();

        /** start Nifty example landing game*/
        niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                assetManager, inputManager, audioRenderer, guiViewPort);
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("testInterface.xml", "start",new MarsLandingStartScreen());

    }

    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
    }

    @Override
    public void cleanup(Application app) {
    }

    @Override
    public void onDisable() {
        guiViewPort.clearProcessors();
        guiViewPort.setBackgroundColor(ColorRGBA.Black);

    }

    @Override
    public void onEnable() {
        guiViewPort.setBackgroundColor(ColorRGBA.Green);
        guiViewPort.addProcessor(niftyDisplay);



    }

    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    public void onStartScreen() {
        Element landingButton = nifty.getCurrentScreen().findElementById("landingButton");
        landingButton.getElementInteraction().getPrimary().setOnClickMethod(new NiftyMethodInvoker(nifty, "startLanding()", this));
        landingButton.bindControls(nifty.getCurrentScreen());
   }

    public void onEndScreen() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startLanding() {
        Element niftyElement = nifty.getCurrentScreen().findElementById("inhalt");

        String treibstoff = screen.findNiftyControl("treibstoff", TextField.class).getDisplayedText();
        String nutzlast = screen.findNiftyControl("nutzlast", TextField.class).getDisplayedText();

        Integer gesamtMenge = 0;
        Float ratio = 0.0f;
        try {
            gesamtMenge = Integer.valueOf(treibstoff)+Integer.valueOf(nutzlast);
            ratio = Float.valueOf(treibstoff)/Float.valueOf(nutzlast);

        } catch(Exception e) {
            System.out.println("error in tranformation");
        }
        String formel = treibstoff + " + " + nutzlast + " = "+ gesamtMenge + ".   ";

        if(gesamtMenge > 500) {
            niftyElement.getRenderer(TextRenderer.class).setText(formel + "Du hast zuviel mitgenommen, packe deine Rakete erneut.");        // start the game and do some more stuff...

        }
        else if(gesamtMenge == 0) {
            niftyElement.getRenderer(TextRenderer.class).setText("Gebe Zahlen zwischen 0 und 500 ein.");
        }
        else if(gesamtMenge < 500) {
            niftyElement.getRenderer(TextRenderer.class).setText(formel + "Pack ruhig etwas mehr ein.");
        }
        else {
            String antwort;
            if(ratio < .17f) {
                antwort = "Du bist unten... aber du warst so schwer, dein Raumschiff ist an der roten Kruste des Mars zerschellt wie eine Melone.";
            }
            else if(ratio > .29f) {
                antwort = "Du bist angekommen, aber hast nichtmal genug dabei, um die erste Woche zu überstehen.";
            }
            else {
                antwort = "Du bist gelandet souverän und kannst mit der Besiedlung beginnen.";
            }
            niftyElement.getRenderer(TextRenderer.class).setText( formel + antwort );        // start the game and do some more stuff...

        }
    }

}
