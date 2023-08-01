import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** A utility class used to generate the rock map to be used in the program
 * @author Aaron Dichoso & Andrei Martin
 * @version 3.2
 * @since 30/11/2022
 */
public class fileoutput {

    public static final String ROCK_MAP_FILE_NAME = "rocks.cfg";
    private static int[] rockIDs = {0, 4, 17, 25, 46, 33, 20, 22, 9};
    public static void main(String[] args) throws IOException
    {
        FileOutputStream out = null;
        
        //Try to generate the rock map config file
        try
        {
            out = new FileOutputStream(ROCK_MAP_FILE_NAME);

            for(int id : rockIDs)
                out.write(id);
        }
        finally
        {
            if(out != null)
                out.close();
        }
    }

    /**
     * Place rocks all over the tiles
     * private void generateRockMap()
        {
            FileInputStream in = null;

            //Try to read the generated rock config file, if possible
            try
            {
                in = new FileInputStream(RockMapGenerator.ROCK_MAP_FILE_NAME);

                int c;
                //Using the given tile ID, place a rock on there
                while((c = in.read()) != -1)
                {
                    Tile tile = getTileWithID(c);
                    if(!tile.equals(null))
                        tile.setStateID(Tile.ROCKY);
                }
            }
            catch (IOException e)
            {
                //Default rock if config not found
                Tile tile = getTileWithID(39);
                if(!tile.equals(null))
                    tile.setStateID(Tile.ROCKY);

                System.out.println(e);
            }
        }
     */
    
}

