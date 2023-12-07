package logs.helper;

import lombok.Getter;

@Getter
public class UserAgent {
  private final String typeSystem;
  private final String nameBrowser;

  public UserAgent(String userAgent) {
    this.typeSystem = identifySystem(userAgent);
    this.nameBrowser = identifyBrowser(userAgent);;
  }



  public static String identifyBrowser(String s) {
    if (s.contains("Chrome") && s.contains("Safari") && s.contains("Edge"))
      return "Edge";
    else if (s.contains("Chrome") && s.contains("Safari") && s.contains("OPR"))
      return "OPR";
    else if (s.contains("Chrome") && s.contains("Safari"))
      return "Chrome";
    else if (s.contains("Firefox"))
      return "Firefox";
    else if (s.contains("Safari"))
      return "Safari";
    else if (s.contains("compatible"))
      return "compatible";
    else if (s.contains("curl"))
      return "curl";
    else
      return "PostmanRuntime";
  }

  public static String identifySystem(String s) {
    if (s.contains("Linux"))
      return "Linux";
    else if (s.contains("Windows"))
      return "Windows";
    else if (s.contains("Mac"))
      return "macOS";
    else
      return "none";
  }
}