import http from 'k6/http';
import { group } from 'k6';
import { Trend, Rate } from 'k6/metrics';

const demoSpringDuration = new Trend('demo_spring.duration', true);
const demoQuarkusDuration = new Trend('demo_quarkus.duration', true);


const demoSpringSuccessRate = new Rate('demo_spring.success_rate');
const demoQuarkusSuccessRate = new Rate('demo_quarkus.success_rate');

const demoSpringErrorRate = new Rate('demo_spring.error_rate');
const demoQuarkusErrorRate = new Rate('demo_quarkus.error_rate');


export const options = {
  discardResponseBodies: true,
  scenarios: {
    contacts: {
      executor: 'ramping-vus',
      startVUs: 0,
      stages: [
        { duration: '10s', target: 100 },
        { duration: '10s', target: 10 },
        { duration: '10s', target: 100 },
      ],
      gracefulRampDown: '0s',
    },
  },
};

export default function () {
    group('with promises all', () => {
        const res = http.get('http://localhost:8081/demo');
        demoSpringDuration.add(res.timings.duration);
        demoSpringSuccessRate.add(res.status == 200);
        demoSpringErrorRate.add(res.status > 200);
    });
    group('without promises all', () => {
        const res = http.get('http://localhost:8080/demo');
        demoQuarkusDuration.add(res.timings.duration);
        demoQuarkusSuccessRate.add(res.status == 200);
        demoQuarkusErrorRate.add(res.status > 200);
    });
}