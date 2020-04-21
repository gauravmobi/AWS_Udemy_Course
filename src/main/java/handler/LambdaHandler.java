package handler;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import requestresponseclasses.RequestClass;
import requestresponseclasses.ResponseClass;

public class LambdaHandler implements RequestHandler<RequestClass, ResponseClass> {

    private DynamoDB dynamoDb;
    private String DYNAMODB_TABLE_NAME = "Person";
    private Regions REGION = Regions.AP_SOUTH_1;

    @Override
    public ResponseClass handleRequest(RequestClass requestClass, Context context) {

        this.initDynamoDbClient();

        persistData(requestClass);

        ResponseClass responseClass = new ResponseClass();

        responseClass.setGreetings("Saved Successfully!!!");
        return responseClass;
    }

    private PutItemOutcome persistData(RequestClass requestClass)
            throws ConditionalCheckFailedException {
        return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
                .putItem(
                        new PutItemSpec().withItem(new Item()
                                .withString("firstName", requestClass.getFirstName())
                                .withString("lastName", requestClass.getLastName())
                                .withString("id", requestClass.getId())));
    }

    private void initDynamoDbClient() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(REGION));
        this.dynamoDb = new DynamoDB(client);
    }
}
//        ctrl.diaptcRequest(requestClass) vctrl  new C();
//
//        //control
//        public void dispatchRequest(){
//            getHtp;
//            reuestType = getRequestType();
//            swicth(requestType)
//        }{
//            GET_ALL_DEVVDS:
//            ();
//        }getAllDevds