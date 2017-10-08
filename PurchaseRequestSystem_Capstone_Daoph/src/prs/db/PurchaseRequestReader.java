package prs.db;

import java.util.ArrayList;

import prs.business.PurchaseRequest;

public interface PurchaseRequestReader {

	ArrayList<PurchaseRequest> getPurchaseRequests();
	
	ArrayList<PurchaseRequest> getPendingRequests();
	
	ArrayList<PurchaseRequest> getPendingRequests(String s);
}
