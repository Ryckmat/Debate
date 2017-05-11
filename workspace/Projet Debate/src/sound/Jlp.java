package sound;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.Player;

public class Jlp extends Thread
{
    private String fFilename = null;
    private boolean remote = false;

    static public Jlp createInstance(String[] args)
    {
        Jlp player = new Jlp();
        if (!player.parseArgs(args))
                player = null;
        return player;
    }

    public Jlp() {}

    public Jlp(String filename)
    {
        init(filename);
    }

    protected void init(String filename)
    {
        fFilename = filename;
    }

    protected boolean parseArgs(String[] args)
    {
        boolean parsed = false;
        if (args.length == 1)
        {
                init(args[0]);
                parsed = true;
                remote = false;
        }
        else if (args.length == 2)
        {
                if (!(args[0].equals("-url")))
                {
                        showUsage();
                }
                else
                {
                        init(args[1]);
                        parsed = true;
                        remote = true;
                }
        }
        else
        {
                showUsage();
        }
        return parsed;
    }

    public void showUsage()
    {
        System.out.println("Usage: jlp [-url] <filename>");
        System.out.println("");
        System.out.println(" e.g. : java javazoom.jl.player.jlp localfile.mp3");

    }
    public void stopSound() throws JavaLayerException
    {
        try
        {
                InputStream in = null;
                if (remote == true)
                        try {
                                in = getURLInputStream();
                        } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                else in = getInputStream();
                AudioDevice dev = getAudioDevice();
                Player player = new Player(in, dev);
                player.close();
        }
        catch (IOException ex)	{}

    }

    public void play()
            throws JavaLayerException
    {
            try
            {
                System.out.println("playing "+fFilename+"...");
                InputStream in = null;
                if (remote == true) in = getURLInputStream();
                else in = getInputStream();
                AudioDevice dev = getAudioDevice();
                Player player = new Player(in, dev);
                player.play();
            }
            catch (IOException ex)
            {
                    throw new JavaLayerException("Problem playing file "+fFilename, ex);
            }
            catch (Exception ex)
            {
                    throw new JavaLayerException("Problem playing file "+fFilename, ex);
            }
    }

    /**
     * Jouer fichier de l' URL (Streaming).
     */
    protected InputStream getURLInputStream() throws Exception
    {

            URL url = new URL(fFilename);
            InputStream fin = url.openStream();
            BufferedInputStream bin = new BufferedInputStream(fin);
            return bin;
    }

    /**
     * Jouer un fichier de FileInputStream.
     */
    protected InputStream getInputStream() throws IOException
    {
            FileInputStream fin = new FileInputStream(fFilename);
            BufferedInputStream bin = new BufferedInputStream(fin);
            return bin;
    }

    protected AudioDevice getAudioDevice() throws JavaLayerException
    {
            return FactoryRegistry.systemRegistry().createAudioDevice();
    }

    public void run() {
        while(true)
        {
            try {
                this.play();
            }catch (Exception e) {e.printStackTrace(); break;}
        }
    }

    public static void main(String[] ar)
    {
        Jlp mp=new Jlp();
        mp.init("/home/julien/main.mp3");
        try {
            mp.play();
        }catch (Exception e) {e.printStackTrace();}
    }

    protected void init(URL resource) {
        fFilename = resource.getFile() ;
    }
}