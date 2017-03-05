package com.pluralsight.queues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HelpDeskPriorityQueue {

	// The Category has an order (the order of the items listed in the enum)
	// Use a priority queue, with a comparator based constructor to use as the
	// ordering
	private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
		public int compare(final Enquiry o1, final Enquiry o2) {
			// compare to method on enum that is implemented by every enum
			// class, ordering in enum order
			return o1.getCategory().compareTo(o2.getCategory());
		}
	};

	private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

	public void enquire(final Customer customer, final Category category) {
		// Offer a new enquiry into the queue
		enquiries.offer(new Enquiry(customer, category));
	}

	public void processAllEnquiries() {
		Enquiry enquiry;
		while ((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply(
					"Have you tried turning it off and on again?");
		}

	}

	public static void main(String[] args) {
		HelpDeskPriorityQueue helpDesk = new HelpDeskPriorityQueue();

		// with the priority queue, highest priority will be printer, then
		// computer, then phone

		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, Category.PRINTER);
		helpDesk.enquire(Customer.MARY, Category.COMPUTER);

		helpDesk.processAllEnquiries();
		helpDesk.processAllEnquiries();
		helpDesk.processAllEnquiries();

	}

}
