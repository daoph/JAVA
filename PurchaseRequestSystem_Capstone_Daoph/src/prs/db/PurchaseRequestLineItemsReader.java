package prs.db;

import java.util.ArrayList;

import prs.business.PurchaseRequestLineItem;


public interface PurchaseRequestLineItemsReader {

	ArrayList<PurchaseRequestLineItem> getLineItems();
	
}


