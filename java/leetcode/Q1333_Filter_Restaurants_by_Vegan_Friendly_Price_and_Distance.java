package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1333_Filter_Restaurants_by_Vegan_Friendly_Price_and_Distance {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> answer = solution.filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 1, 50, 10);
        // [3,1,5]
        System.out.println(answer);
        //[4,3,2,1,5]
        answer = solution.filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 50, 10);
        System.out.println(answer);
        //[4,5]
        answer = solution.filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 30, 3);
        System.out.println(answer);

    }


    public static class Solution {

        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            RestaurantList restaurantList = new RestaurantList();

            for (final int[] restaurant : restaurants) {
                restaurantList.add(new Restaurant(restaurant[0], restaurant[1], restaurant[2], restaurant[3], restaurant[4]));
            }

            return restaurantList.findVeganRestaurant(veganFriendly, maxPrice, maxDistance);
        }


        public static class Restaurant implements Comparable<Restaurant> {

            private int id;
            private int rating;
            private int veganFriendly;
            private int price;
            private int distance;

            public Restaurant(final int id, final int rating, final int veganFriendly, final int price, final int distance) {
                this.id = id;
                this.rating = rating;
                this.veganFriendly = veganFriendly;
                this.price = price;
                this.distance = distance;
            }

            private boolean veganFilter(int filterButton) {
                if (filterButton == 0) {
                    return true;
                } else {
                    return this.veganFriendly == 1;
                }
            }

            private boolean maxPriceFilter(int price) {
                return this.price <= price;
            }

            private boolean maxDistance(int distance) {
                return this.distance <= distance;
            }


            @Override
            public int compareTo(final Restaurant o) {
                if (o.rating < rating) {
                    return -1;
                } else if (o.rating == rating) {
                    return o.id - id;
                } else {
                    return 1;
                }
            }
        }

        public static class RestaurantList {

            ArrayList<Restaurant> restaurants = new ArrayList<>();

            private void add(Restaurant restaurant) {
                restaurants.add(restaurant);
            }

            private List<Integer> findVeganRestaurant(int vegan, int price, int distance) {
                List<Integer> answer = new ArrayList<>();

                List<Restaurant> veganRestaurant = new ArrayList<>();

                for (final Restaurant restaurant : restaurants) {
                    if (restaurant.veganFilter(vegan) && restaurant.maxPriceFilter(price) && restaurant.maxDistance(distance)) {
                        veganRestaurant.add(restaurant);
                    }
                }

                veganRestaurant.sort(Restaurant::compareTo);
                for (final Restaurant restaurant : veganRestaurant) {
                    answer.add(restaurant.id);
                }
                return answer;
            }
        }
    }
}
