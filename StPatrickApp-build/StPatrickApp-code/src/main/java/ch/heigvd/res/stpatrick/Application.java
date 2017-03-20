package ch.heigvd.res.stpatrick;


import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * @author Olivier Liechti
 */
public class Application {

  IStreamProcessorsFactory processorsFactory = new StreamProcessorsFactory();
  
  public IStreamProcessorsFactory getStreamProcessorsFactory() {
    return processorsFactory;
  }

  IStreamDecoratorController getStreamDecoratorController() {
    return new IStreamDecoratorController() {
      @Override
      public Reader decorateReader(Reader inputReader) {
        return new Reader() {
          @Override
          public int read(char[] cbuf, int off, int len) throws IOException {
            return 0;
          }
          @Override
          public int read(){
            int c = 0;

            try {
               c = super.read();
            } catch (IOException e) {
              e.printStackTrace();
            }
            if(c != 'a' && c != 'A')
              return c;
            else{
              return Integer.parseInt(null);
            }
          }

          @Override
          public void close() throws IOException {

          }
        };
      }

      @Override
      public Writer decorateWriter(Writer outputWriter) {
        return null;
      }
    };
  }
}
