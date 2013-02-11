package miniature.cyril

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._


// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MiniCServiceActor extends Actor with MiniCRouteService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(miniCRoute)
}


// this trait defines our service behavior independently from the service actor
trait MiniCRouteService extends HttpService {

  val miniCRoute =
    path("account") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>account route</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    } ~
    path("view") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>view route</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      } 
    } ~
    path("view" / IntNumber) { viewId => 
      respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          <html>
            <body>
              <h1>Say hello to <i>view route</i> with <i>{viewId}</i>!</h1>
            </body>
          </html>
        }
      }
    }
}
