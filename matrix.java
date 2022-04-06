/**
 * matrix
 */
public class matrix {

    public static void main(String[] args) {
        int[] imgTest = new int[50]; // 5 rows of 10
        for(int i = 0; i < imgTest.length; i ++) {
            imgTest[i] = i;
        }

        int startPx = 0;
        int startPy = 2;

        int[] filter = {
            2, 4, 5, 4, 2,
            4, 9, 12, 9, 4,
            5, 12, 15, 12, 5,
            4, 9, 12, 9, 4,
            2, 4, 5, 4, 2
        };
        convolution(startPx, startPy, filter, 5, imgTest, 10, 5);
    }

    /**
     * CONVOLVE
     * @param GID start pixel (center)
     * @param filter filter to apply to pixel and surrounding pixels
     * @param size size of filter, filters must be squares
     */
    private static void convolution(int xCentre, int yCentre, int[] filter, int size, int[] img, int width, int height) {
        String outStr = "";
        if (size * size != filter.length) {
            System.err.println ("Filter not a square");
            return;
        }
        
        int filterHalf = size / 2;
        for (int filterY = 0; filterY < size; filterY ++) {
            int y = wrap(yCentre + filterY - filterHalf, height);
            for(int filterX = 0; filterX < size; filterX ++) {
                int x = wrap(xCentre + filterX - filterHalf, width);
                outStr += img[y * width + x] + " ";
            }
            System.out.println(outStr);
            outStr = "";
        }
    }

    public static int wrap(int pos, int size) {
        return (pos < 0) ? (-1 - pos) : (pos >= size) ? (size - 1) - (pos - size) : pos;
        // if (pos < 0) {
        //     pos = -1 - pos;
        // } else if (pos >= size) {
        //     pos = (size - 1) - (pos - size);
        // }
        // assert 0 <= pos;
        // assert pos < size;
        // return pos;
    }
}