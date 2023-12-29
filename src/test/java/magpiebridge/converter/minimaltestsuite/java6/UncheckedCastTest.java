package magpiebridge.converter.minimaltestsuite.java6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import magpiebridge.converter.minimaltestsuite.MinimalTestSuiteBase;

public class UncheckedCastTest extends MinimalTestSuiteBase {

  public String getMethodSignature() {
    return identifierFactory.getMethodSignature(
        "uncheckedCastDisplay", getDeclaredClassSignature(), "void", Collections.emptyList());
  }

  @Override
  public List<String> expectedBodyStmts() {
    return Stream.of(
            "r0 := @this: UncheckedCast",
            "$r1 = newarray (java.lang.Object)[4]",
            "$r1[0] = 5",
            "$r1[1] = 8",
            "$r1[2] = 9",
            "$r1[3] = 6",
            "$r2 = staticinvoke <java.util.Arrays: java.util.List asList(java.lang.Object[])>($r1)",
            "$r3 = $r2",
            "$r4 = <java.lang.System: java.io.PrintStream out>",
            "virtualinvoke $r4.<java.io.PrintStream: void println(java.lang.Object)>($r3)",
            "return")
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
