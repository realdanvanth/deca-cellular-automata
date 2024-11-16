import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class a1 {
    JFrame frame;
    private JPanel panel;
    private int[][][] array3D;
    private int frameWidth, frameHeight;
    private int frameRate = 60; // 30 frames per second
    private int currentFrame = 0;

    public a1(int[][][] array3D) {
        this.array3D = array3D;
        frameWidth = array3D[0].length;
        frameHeight = array3D[0][0].length;

        frame = new JFrame("Array to Video Player");
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentFrame < array3D.length) {
                    BufferedImage frameImage = createFrameImage(array3D[currentFrame]);
                    g.drawImage(frameImage, 0, 0, null);
                    currentFrame++;
                    if (currentFrame == array3D.length) {
                        //currentFrame = 0; // Loop the video
                    }
                }
            }
        };

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);

        playVideo();
    }

    private BufferedImage createFrameImage(int[][] frameData) {
        BufferedImage frameImage = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < frameWidth; x++) {
            for (int y = 0; y < frameHeight; y++) {
                int pixelValue = frameData[x][y];
                Color color;
                if (pixelValue == 0) {
                    color = Color.WHITE;
                } else if (pixelValue == 1) {
                    color = Color.BLACK;
                } else if (pixelValue >= 2 && pixelValue <= 9) {
                    // Assign different colors to numbers 2 to 9
                    switch (pixelValue) {
                        case 2:
                            color = Color.RED;
                            break;
                        case 3:
                            color = Color.GREEN;
                            break;
                        case 4:
                            color = Color.YELLOW;
                            break;
                        case 5:
                            color = Color.BLUE;
                            break;
                        case 6:
                            color = Color.ORANGE;
                            break;
                        case 7:
                            color = Color.CYAN;
                            break;
                        case 8:
                            color = Color.MAGENTA;
                            break;
                        case 9:
                            color = Color.PINK;
                            break;
                        default:
                            color = Color.WHITE; // Default to white for unknown values
                    }
                } else {
                    color = Color.WHITE; // Default to white for other values
                }
                frameImage.setRGB(x, y, color.getRGB());
            }
        }
        return frameImage;
    }

    void playVideo() {
        Timer timer = new Timer(1000 / frameRate, e -> panel.repaint());
        timer.start();
    }

    
}
