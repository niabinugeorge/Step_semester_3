package encapsulation.assigment_problems;

/**
 * Problem 5: The Shopping Cart
 *
 * A Cart that stores item prices privately and only exposes the total
 * and item count — never the individual prices.
 */
public class Problem5_TheShoppingCart {

    static class Cart {
        private final String cartId;
        private final int[] prices;
        private int itemCount;

        public Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            this.prices = new int[maxItems];
            this.itemCount = 0;
        }

        public String getCartId() {
            return cartId;
        }

        public void addItem(int price) {
            if (itemCount >= prices.length) {
                System.out.println("Cart is full — cannot add item priced " + price + ".");
                return;
            }
            prices[itemCount] = price;
            itemCount++;
        }

        /** Computed on request by summing the private array — not stored separately. */
        public int getTotal() {
            int total = 0;
            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }
            return total;
        }

        public int getItemCount() {
            return itemCount;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("getTotal() -> " + cart.getTotal());         // 500
        System.out.println("getItemCount() -> " + cart.getItemCount()); // 3
    }
}
