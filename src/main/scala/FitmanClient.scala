
import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.httpclient.modules.HttpClientModule
import com.twitter.finatra.httpclient.{HttpClient, RequestBuilder, RichHttpClient}
import com.twitter.finatra.json.FinatraObjectMapper
import com.twitter.util.Future

object FitmanClient {

  def main(args: Array[String]): Unit = {

    val mapper: FinatraObjectMapper = FinatraObjectMapper.create(injector = null)
    val path = "/"
    val req: Request = RequestBuilder.get("google.com:80")
    val clientModule: FitmanHttpClientModule = new FitmanHttpClientModule()

    // How do we create this service???????
    val service: Service[Request, Response] = Service.mk[Request, Response] { req: Request =>
      val rep = Response()
      rep.statusCode(604)
      Future.value(rep)
    }


    val client = clientModule.provideHttpClient(mapper, service)
    client.execute(req).onSuccess{ response: Response =>
      println("received response " + response.statusCode + " " + response)
    }
  }


  class FitmanHttpClientModule extends HttpClientModule {

    override def dest: String = "/"

    override def hostname: String = "google.com:80"

  }
}
