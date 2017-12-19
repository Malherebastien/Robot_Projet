
package projet;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Audio extends Thread
{
    private URL url;
    private AudioClip sound;

    public Audio(String nomFichier)
    {
        try{
            url = this.getClass().getClassLoader().getResource( nomFichier ); // renvoie le chemin jusqu'au dossier source (src)
            sound = Applet.newAudioClip(url);                                 // nomFichier possede le chemin qu'il y a apres le dossier src
        }catch (Exception e ) { e.printStackTrace(); }

    }

    public void jouer()
    {
        sound.play();
    }

    public void jouerEnBoucle()
    {
        sound.loop();
    }

    public void arreter()
    {
        sound.stop();
    }
}
