    import java.util.ArrayList;


    public class SearchService {

        private Library library;

        public SearchService(Library bookDatabase) {
            this.library = bookDatabase;
        }

        public ArrayList<Book> searchByBook(String query) {
            return library.searchBooks(query);
        }

        public ArrayList<Customer> searchCustomers(String name) {
            ArrayList<Customer> searchResults = new ArrayList<>();

            for (Customer customer : library.getCustomers()) {
                if (customer.getName().contains(name)) {
                    searchResults.add(customer);
                }
            }
            return searchResults;
        }





        public Customer searchCustomer(String name) {
            Customer customer = library.findCustomer(name);
            return customer;
        }


    }
