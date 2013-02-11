package miniature.cyril

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._


class MiniCRouteServiceSpec extends Specification with Specs2RouteTest with MiniCRouteService {
  def actorRefFactory = system
  
  "MiniCService" should {

    "return a greeting for GET requests to the /account path" in {
      Get("/account") ~> miniCRoute ~> check {
        entityAs[String] must contain("Say hello")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> miniCRoute ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the /account path" in {
      Put("/account") ~> sealRoute(miniCRoute) ~> check {
        status === MethodNotAllowed
        entityAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
