package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadSave {

    public static BufferedImage GetSpriteAtlas(String location, String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/textures/" + location + "/" +fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage[] GetAllLevels() {
        File file = new File("src/main/resources/lvls");

        File[] files = file.listFiles();
        assert files != null;
        File[] filesSorted = new File[files.length];

        for (int i = 0; i < filesSorted.length; i++) {
            for (File value : files) {
                if (value.getName().equals((i + 1) + ".png"))
                    filesSorted[i] = value;
            }
        }

        BufferedImage[] imgs = new BufferedImage[files.length];

        for (int i = 0; i < imgs.length; i++) {
            try {
                imgs[i] = ImageIO.read(filesSorted[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return imgs;
    }

}
