import com.twitter.finagle.http.Response
import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}
import com.twitter.conversions.time._

object FitmanClient {

  def main(args: Array[String]): Unit = {

    //define a client
    val client: Service[http.Request, http.Response] = Http.client.newService("google.com:80")
    //define a request
    val request = http.Request("/")
    //apply request on the client
    val future: Future[Response] = client(request)
    future.onSuccess { response: http.Response =>
      return response
    }
    val response: Response = Await.result[Response](future, 2.seconds)
    println("CODE:" + response.statusCode)
  }
}
