package prs.db;

import java.util.ArrayList;

import prs.business.PurchaseRequest;

public interface PurchaseRequestReader {

	ArrayList<PurchaseRequest> getPurchaseRequests();
	
	ArrayList<PurchaseRequest> getPurchaseRequests(int i);
	
	ArrayList<PurchaseRequest> getPendingRequests();
	
	ArrayList<PurchaseRequest> getPendingRequests(String s);
	
	ArrayList<PurchaseRequest> getPendingRequests(int i);
}
