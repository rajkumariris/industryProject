package dev.raj.industrylevelproject.Controllers.WebhookController;


import com.stripe.model.Event;
import com.stripe.net.Webhook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook/stripe")
public class StripeWebhookController {


    // there is some tool like local tunnal or ngrok to test webhook with localhost
    // we cannot call directly from public domain to localhost
    /// but this tool help to create local domain by using two command
    // npm install -g localtunnel
    // lt --port 8000
    // this will create a local domain and we can use this domain to test webhook
    // we can use this domain in stripe webhook settings
    // when we completed giving card details and payment is done it redirects us to this page
    // callback url is the url where we want to redirect after payment is done both get sent but webhook url is much faster
    // if both are not possile we use reconciliation to check the payment is done or not


    @GetMapping("/")
    public void handleStripeWebhook(@RequestBody Event event){

        System.out.println("Stripe Webhook Received");
    }
}
