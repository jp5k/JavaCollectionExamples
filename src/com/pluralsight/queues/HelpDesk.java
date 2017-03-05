package com.pluralsight.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class HelpDesk {

	private final Queue<Enquiry> enquiries = new ArrayDeque<>();

	public void enquire(final Customer customer, final Category category) {
		// Offer a new enquiry into the queue
		enquiries.offer(new Enquiry(customer, category));
	}

	public void processPrinterEnquiry() {
		// Java 8 allows us to use Predicates, which means we can reduce the
		// code duplication.
		final String message = "Is it out of paper?";
		processEnquiry(
				(Predicate<Enquiry>) enq -> enq.getCategory() == Category.PRINTER,
				message);

	}

	public void processGeneralEnquiry() {

		final String message = "Have you tried turning it off and on again?";

		processEnquiry(
				(Predicate<Enquiry>) enq -> enq.getCategory() != Category.PRINTER,
				message);
	}

	public void processEnquiry(Predicate predicate, String message) {
		final Enquiry enquiry = enquiries.peek();
		if (enquiry != null && predicate.test(enquiry)) {
			// remove from queue, reply to message.
			enquiries.remove();
			enquiry.getCustomer().reply(message);

		} else {
			System.out.println("No work to do, let's have some coffee");
		}
	}

	public static void main(String[] args) {
		HelpDesk helpDesk = new HelpDesk();

		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, Category.PRINTER);

		helpDesk.processPrinterEnquiry();
		helpDesk.processGeneralEnquiry();
		helpDesk.processPrinterEnquiry();
	}

}
