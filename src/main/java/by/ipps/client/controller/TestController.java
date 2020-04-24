package by.ipps.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Slf4j
public class TestController {

  @GetMapping
  public ResponseEntity<HttpStatus> test(HttpServletRequest request, HttpSession session){
    log.info(request.getRemoteAddr());
    log.info(request.getLocalAddr());
    log.info(request.getServerName());
    log.info(request.getRemoteHost());
    log.info(getClientIp());
    log.info(getIpAddr(request));
    log.info(getClientIpAddress(request));
    log.info(String.valueOf(getRequestHeadersInMap(request)));
    int a = 0;
    try{
      a = (int) session.getAttribute("count");
      a++;
    }catch (NullPointerException e) {
      a = 1;
    }
    session.removeAttribute("count");
    session.setAttribute("count", a);
    log.info(String.valueOf(a));
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @Autowired
  private HttpServletRequest request;

  private String getClientIp() {

    String remoteAddr = "";

    if (request != null) {
      remoteAddr = request.getHeader("X-FORWARDED-FOR");
      if (remoteAddr == null || "".equals(remoteAddr)) {
        remoteAddr = request.getRemoteAddr();
      }
    }

    return remoteAddr;
  }

  private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

    Map<String, String> result = new HashMap<>();

    Enumeration headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String key = (String) headerNames.nextElement();
      String value = request.getHeader(key);
      result.put(key, value);
    }

    return result;
  }

  public static String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("X-Real-IP");
    if (null != ip && !"".equals(ip.trim())
            && !"unknown".equalsIgnoreCase(ip)) {
      return ip;
    }
    ip = request.getHeader("X-Forwarded-For");
    if (null != ip && !"".equals(ip.trim())
            && !"unknown".equalsIgnoreCase(ip)) {
// get first ip from proxy ip
      int index = ip.indexOf(",");
      if (index != -1) {
        return ip.substring(0, index);
      } else {
        return ip;
      }
    }
    return request.getRemoteAddr();
  }

  private static final String[] IP_HEADER_CANDIDATES = {
          "X-Forwarded-For",
          "Proxy-Client-IP",
          "WL-Proxy-Client-IP",
          "HTTP_X_FORWARDED_FOR",
          "HTTP_X_FORWARDED",
          "HTTP_X_CLUSTER_CLIENT_IP",
          "HTTP_CLIENT_IP",
          "HTTP_FORWARDED_FOR",
          "HTTP_FORWARDED",
          "HTTP_VIA",
          "REMOTE_ADDR" };

  public static String getClientIpAddress(HttpServletRequest request) {
    for (String header : IP_HEADER_CANDIDATES) {
      String ip = request.getHeader(header);
      if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
        return ip;
      }
    }
    return request.getRemoteAddr();
  }
}
