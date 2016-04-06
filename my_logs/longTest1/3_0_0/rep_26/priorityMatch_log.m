
% 2015-10-17 01:04:15

% my_logs\longTest1\3_0_0\rep_26\priorityMatch_log.m
scheduling_duration_us = 8272;

% schedule
schedule_f_t_n(:,:,1) = [5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 0; 0];
schedule_f_t_n(:,:,2) = [25; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 10; 0; 0; 0; 0; 0; 0; 0; 0; 5; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 30; 30; 30; 30; 30; 30; 30; 15; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,5) = [5; 20; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,6) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5; 5];
schedule_f_t_n(:,:,7) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 15; 10; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,8) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 14; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 2730, 0, 0, 0, 0];
vioDl = [250, 0, 0, 0, 0, 50, 0, 0];
vioNon = [847, 0, 0, 0, 0, 6390, 0, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [0, 0, 0, 0, 0, 0, 0, 0];
vioLcy = [9200, 0, 0, 0, 0, 6160, 0, 0];
vioJit = [575, 0, 0, 0, 0, 275, 0, 0];
cost_vio = 264722;
cost_switches = 0;
cost_ch = 5988;
costTotal = 270710;

% priorityMatch
% 
% ############### Network 0 ##############
% F0	|[0]5	|5	|5	|5	|5	|5	|5	|5	|5	|5	|[10]5	|5	|5	|5	|5	|5	|5	|5	|5	|5	|[20]5	|5	|5	|	|	|
% F1	|[0]25	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|10	|	|	|	|	|	|	|	|	|[10]5	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|30	|30	|30	|30	|30	|30	|30	|15	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F4	|[0]5	|20	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|5	|5	|5	|5	|5	|5	|[20]5	|5	|5	|5	|5	|
% F6	|[0]	|	|	|	|	|	|	|	|	|15	|[10]10	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F7	|[0]	|	|	|	|	|	|	|	|	|	|[10]14	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
