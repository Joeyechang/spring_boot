package com.tts.processor

import java.io.File

import us.codecraft.webmagic.{Page, Site, Spider}
import us.codecraft.webmagic.processor.PageProcessor

import scala.sys.process._
import io.{Source, StdIn}
import java.io.{File => JFile}

/**
  * Created by mike on 2016/10/15.
  */
object ShadowProcessor extends PageProcessor {
  override def getSite: Site = Site.me.setRetryTimes(3).setSleepTime(1000).setUseGzip(true);

  override def process(page: Page): Unit = {
    val jpServer: String = String.valueOf(page.getHtml.xpath("//*[@id=\"free\"]/div/div[2]/div[3]/h4[1]/text()")).substring(7).toUpperCase
    val jpPort: String = String.valueOf(page.getHtml.xpath("//*[@id=\"free\"]/div/div[2]/div[3]/h4[2]/text()")).substring(3)
    val jpPassword: String = String.valueOf(page.getHtml.xpath("//*[@id=\"free\"]/div/div[2]/div[3]/h4[3]/text()")).substring(4)
    var config: String = "{\"configs\" : [  {\"server\" : \"SSSSSS\",\"server_port\" : PPPPPP,\"password\" : \"XXXXXX\",\"method\" : \"aes-256-cfb\",\"remarks\" : \"\"}],\"strategy\" : null,\"index\" : 0,\"global\" : false,\"enabled\" : true,\"shareOverLan\" : false,\"isDefault\" " + ": false,\"localPort\" : 1080,\"pacUrl\" : null,\"useOnlinePac\" : false,\"availabilityStatistics\" : false}"
    config = config.replaceAll("SSSSSS", jpServer).replaceAll("PPPPPP", jpPort).replaceAll("XXXXXX", jpPassword)

    better.files.File("D:\\downloads\\shadowsocks\\gui-config.json") < config

    //Kill Shadowsocks.exe
    val shadow = Process("tasklist").lineStream.filter(l => l.startsWith("Shadowsocks"))
    if(shadow.size > 0) Process("taskkill /PID " + shadow.head.split("\\s+")(1) + " /f").run
    Thread.sleep(1000)
    Process("D:\\downloads\\shadowsocks\\Shadowsocks.exe").run
    System.exit(0)
  }

  def main(args: Array[String]) {
    Spider.create(ShadowProcessor).addUrl("http://www.ishadowsocks.net/").thread(1).start
  }

}
