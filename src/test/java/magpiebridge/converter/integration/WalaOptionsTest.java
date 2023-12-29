package magpiebridge.converter.integration;

import com.google.common.collect.Lists;
import com.ibm.wala.classLoader.IClass;
import java.util.ArrayList;
import java.util.Collections;
import magpiebridge.converter.WalaOptions;
import magpiebridge.converter.WalaToSootIRConverter;
import org.junit.Test;
import soot.SootClass;

/** @author Linghui Luo */
public class WalaOptionsTest {

  @Test
  public void testCustomizedWalaProperties() {
    String testSourcePath = "src/test/resources/integration/testcase1/src";
    String testLibPath = "src/test/resources/integration/testcase1/mylib-0.0.1.jar";
    WalaOptions walaOptions = new WalaOptions();

    WalaToSootIRConverter converter =
        new WalaToSootIRConverter(
            Collections.singleton(testSourcePath),
            Collections.singleton(testLibPath),
            null,
            walaOptions);

    ArrayList<IClass> walaClasses = Lists.newArrayList(converter.iterateWalaJavaSourceClasses());

    ArrayList<SootClass> sootClasses =
        converter.convertOnlyClass(converter.iterateWalaJavaSourceClasses());
    // assertEquals(Scene.v().getApplicationClasses().size(), 2);\

    System.out.println("");
  }
}
